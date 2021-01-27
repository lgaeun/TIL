const socket = io('/') // get a reference to socket, socket is connect to root path(3000)
//npm install -g peer (peer server의 역할: connect different users and give userID)
const myPeer = new Peer(undefined , {
	host: '/', // root host
	port: '3001'
}); //undefined인 이유는 서버가 내 아이디 생성하는 걸 주관할거기 때문에

const myVideo = document.createElement('video') //비디오 오브젝트 생성
myVideo.muted = true // mute myself( 내 자신의 마이크 소리를 다시 나에게 들려주지 않게 하기!!)
const peers = {} // 현재 방 안에 있는 사람 keep track하기 위함 

navigator.mediaDevices.geUserMedia({
	video: true, //비디오와 오디오를 보낼 것이기 때문에 
	audio: true

}). then(stream =>{ //위의 것들을 스트림으로 보내서, addVideoStream function을 수행한다
	addVideoStream(myvideo, stream)

	// 누군가 전화를 걸면 우리는 answer call 해서 그 사람의 스트림을 받아오고, 그 사람에게 우리의 stream 보낸다
	myPeer.on('call', call =>{
		call.answer(stream)

		const video = document.createElement('video')
		call.on('stream', userVideoStream =>{
			addVideoStream(video, userVideoStream)
		})
	})

	//socekt의 user connected event: listen to 소켓의 join-room event
	//새로 들어온 유저에게 비디오 스트림 송출하기
	socket.on('user-connected', userId => {
		connectToNewUser(userId, stream)
	})

})

//유저가 방을 나가면 즉시 방에서 유저를 지운다
socket.on('user-disconnected', userId =>{
	//방에 그 아이디를 가진 유저가 아직 존재한다면, 그 유저의 커넥션 끊기
	if(peers[userId]) peers[userId].close()

})

// use peer server, 서버에 연결하는 user의 ID를 얻어준다
myPeer.on('open', id =>{
	// 그리고 이 userid를 서버에게 넘겨주면, 서버는 join-event 가능
	socket.emit('join-room', ROOM_ID, id)
})


function connectToNewUser(userId, stream){
	const call = myPeer.call(userId, stream) //userId로 유저 부르고, stream매개변수로 그 유저에게 스트림을 송출해준다.
	const video = document.createElement('video')
	// 그 유저의 비디오 스트림을 받아오는 이벤트 ('stream')
	call.on('stream', userVideoStream =>{
		addVideoStream(video, userVideoStream) 
	}) //새로들어온 유저의 비디오 스트림(userVideoStream)을 우리의 비디오 스트림(video)에 붙이기
	call.on('close', () =>{
		video.remove() // 유저가 나가면 그 유저의 비디오 지워서 다른 유저들에게 송출되지 않도록 하기 
	})

	// 모든 유저아이디는 call과 연결됨
	peers[userId] = call


}

function addVideoStream(video, stream){
	video.srbObject = stream //source obejcet가 stream인 비디오 만들기
	video.addEventListener('loadedmetaDate', () =>{  //비디오가 로드되면 play that video
		video.play() 
	}) 
	videoGrid.append(video) // 그리고 그 비디오를 브라우저에서 볼 수 있게 비디오 그리드에 append
}


