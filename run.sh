cd waitressAndManager
docker buildx build --platform linux/amd64   -t waitress:1.0 .
cd ..
cd chef
docker buildx build --platform linux/amd64   -t chef:1.0 .
cd ..
cd cashier
docker buildx build --platform linux/amd64   -t cashier:1.0 .
cd ..
pwd

docker-compose up -d