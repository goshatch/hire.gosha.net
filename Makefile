#  ██░ ██  ██▓ ██▀███  ▓█████     ███▄ ▄███▓▓█████
# ▓██░ ██▒▓██▒▓██ ▒ ██▒▓█   ▀    ▓██▒▀█▀ ██▒▓█   ▀
# ▒██▀▀██░▒██▒▓██ ░▄█ ▒▒███      ▓██    ▓██░▒███
# ░▓█ ░██ ░██░▒██▀▀█▄  ▒▓█  ▄    ▒██    ▒██ ▒▓█  ▄
# ░▓█▒░██▓░██░░██▓ ▒██▒░▒████▒   ▒██▒   ░██▒░▒████▒
#  ▒ ░░▒░▒░▓  ░ ▒▓ ░▒▓░░░ ▒░ ░   ░ ▒░   ░  ░░░ ▒░ ░
#  ▒ ░▒░ ░ ▒ ░  ░▒ ░ ▒░ ░ ░  ░   ░  ░      ░ ░ ░  ░
#  ░  ░░ ░ ▒ ░  ░░   ░    ░      ░      ░      ░
#  ░  ░  ░ ░     ░        ░  ░          ░      ░  ░
#
# https://hire.gosha.net


.POSIX:
.PHONY: all build dev deploy clean

REMOTE_HOST = bubundel
REMOTE_PATH = /var/www/hire.gosha.net

all: build

dev:
	bun run dev

build:
	bun run build

deploy: build
	rsync -rvlh --progress --delete dist/ $(REMOTE_HOST):$(REMOTE_PATH)

clean:
	rm -rf dist/js public/js .shadow-cljs
