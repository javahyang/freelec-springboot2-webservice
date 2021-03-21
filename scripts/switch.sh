#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

function switch_proxy() {
    IDLE_PORT=$(find_idle_port)

    echo "> 전환할 Port: $IDLE_PORT"
    echo "> Port 전환할"
    echo "set \$service_url http://127.0.0.1:${IDLE_PORT};" | sudo tee /etc/nginx/conf.d/service-url.inc # 파이프 앞에서 넘겨준 문장(엔진엑스가 변결할 프록시 주소 생성)을 service-url.inc 에 덮어씀.

    echo "> 엔진엑스 Reload"
    sudo service nginx reload # restart 는 잠시 끊기는 현상있지만, reload 는 끊김없이 다시 불러옴. 외부 설정파일 다시 불러오는거라 reload
}