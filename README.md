# DB 
1. install docker
2. run `docker run -p 27017:27017 -d --name lex_db mongo:latest` in your terminal.
# Backend
1. open intellij and use java 19 as jdk
2. start project (automatically runs with profile `data` which generates some dummy data in the db to work with)
# Frontend
1. run `npm install` in the frontend folder
2. run `npm start` in the frontend folder
3. open `http://localhost:5173/` in your browser
## Available EAN Numbers in DB to search for
- 8005647003225
- 4045800773118
- 4006748001404
- 4000799100512
- 1701509200005
- 3184340000542
- 4005800000000
- 4005800000450
- 4005800000459
- 4005800000466