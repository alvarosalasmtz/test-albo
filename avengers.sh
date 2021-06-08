#!/bin/bash
# Ejecuta JAR de API Test Albo en puerto 80
## Author: Alvaro Salas <alvarosalasmtz@gmail.com>
## ---------------------------------------------------------------------------------------------------------------------
now="$(date)"
computer_name="$(hostname)"
GREEN='\033[0;32m'
echo -e "${GREEN}*****************************************************************************************************************"
echo -e "${GREEN}>>>>> DEPLOY..."
(
  sleep 8
  echo -e "${GREEN}>>>>> TIME DEPLOY : $now"
  echo -e "${GREEN}>>>>> HOST NAME IN : $computer_name"
  echo -e "${GREEN}>>>>> OPEN BROWSER................"
  sleep 2
  xdg-open http://test.albo.mx/swagger-ui/index.html
  echo -e "${GREEN}>>>>> SUCCESS n_n" &
) &
sudo java -jar target/test-developer-0.0.1-SNAPSHOT.jar --server.port=80
