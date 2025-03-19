#!/bin/bash
until mysqladmin ping -h mysql -u root -prootpassword --silent; do
    echo "Waiting for MySQL to be ready..."
    sleep 2
done
echo "MySQL is ready!"
exec "$@"