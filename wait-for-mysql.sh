#!/bin/bash
until mysqladmin ping -h mysql -u Qi -p040104 --silent; do
  echo "Waiting for MySQL to be ready..."
  sleep 2
done
echo "MySQL is ready, starting the application..."
exec java -jar app.jar