..\keycloak-13.0.1\bin\standalone.sh -Dkeycloak.migration.action=export -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.realmName=springboot-seeds -Dkeycloak.migration.usersExportStrategy=REALM_FILE -Dkeycloak.migration.file=springboot-seeds.json