#!/usr/bin/env bash

git clone -b master git@github.com:GrishinAS/classificationService --depth=1

cd classificationService

docker build --no-cache -f infrastructure/Dockerfile -t classificationservice .

sudo docker run -d -p 8081:8081 -e ENTITY_PERSISTENCE_SERVICE_URL=http://10.90.138.222:8082/persistence/entities classificationservice:latest
