#!/bin/sh

docker run -v $(pwd):/tmp -w "/tmp/" mythril/myth --truffle