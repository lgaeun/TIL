const express = require('express') //express 서버 생성
cons app = express() //만들어진 express 서버를 넣는 앱
const server = require('http').Server(app) // 서버에 app 전달
const io = requires('socket.io')(server) // socket.io에 서버 전달
const {v4 : uuidV4} = require('uuid')

app.set('view enginge, ejs') //ejs view engine 사용
app.use(express.static('public')) //public folder에 모든 js, css 넣음


app.get('/', (req, res) => {
	res.redirec( `/${roomId}`) //want to get a dynamic room
})

//url에 넘겨주는 다이내믹 paramer = /:room
app.get('/:room', (req,res) => {
	res.render('room', { roomId: req.params.room})
	//browser refresh하면 random uuId가 url에 append된다
})

// 누구나 서버에 접속해서 room에 join을 하면, roomID와 userID를 소켓에 넘겨준다
io.on('connection', socket =>{
	socket/on('join-room', (roomID, userID) => { //joing-room event
		// 위에서 넘겨받는 roomID로 방에 조인하기
		socket.join(roomID)
		//다른 방에 있는 사람들에게 누가 조인했다고 알려주기(broadcast)
		socket.to(roomID).broadcast.emit('uer-connected',userID)

		//call을 나가면(disconnected) 즉시 상대방에게 적용되게 하기
		socket.on('disconnect', () =>{
			//user-disconnected event를 socket에 emit하고, 나간 userId를 넘겨준다
			socket.to(roomID).broadcast.emit('user-disconneted', userId)
		})
	})
})

// 서버 닫아도 통신가능(서버는 setting up room 할때만 사용, p2p통신이어서)
server.listen(3000) 



