#!/bin/bash
# wait-for-it.sh
host=$(echo $1 | cut -d: -f1)
port=$(echo $1 | cut -d: -f2)
shift

timeout=${1:-30}
for i in $(seq 1 $timeout); do
  nc -z $host $port && break
  echo "Waiting for $host:$port..."
  sleep 1
done

exec "$@"
