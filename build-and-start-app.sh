
echo 'Preparing frontend build...'
cd userlogin-frontend && yarn install && yarn build
echo 'Preparing backend build and archiving jar containing both frontend and backend...'
cd ../userlogin-backend && mvn clean install
echo 'lauching the application ...'
java -jar target/userlogin-0.0.1-SNAPSHOT.jar
