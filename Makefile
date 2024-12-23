all : up

up :
# 	mkdir -p $(HOME)/data
# 	chmod 777 ./db/conf/postgresql.conf
# 	chmod 777 $(HOME)/data
# 	#chown -R postgres:postgres ./data
	docker-compose -f docker-compose.yml up -d --build


down :
	docker-compose -f docker-compose.yml down

clean :
	docker-compose -f docker-compose-dev.yml down -v --rmi all

fclean : clean
	rm -rf ./web/client_shared
	docker volume prune -f
	docker image prune -f
	docker system prune -f

all_fclean : clean delete_db
	docker volume prune -f
	docker image prune -f
	docker system prune -f

ls :
	docker ps -a

db_exec:
	docker exec -it postgres17 /bin/bash

db_log:
	docker logs -f postgres17

db_del:
	docker volume rm practice_sample_crud_demo_postgres17

re : down up
.PHONY : all up down clean fclean re


# VMOPTION
# -Dspring.profiles.active=local