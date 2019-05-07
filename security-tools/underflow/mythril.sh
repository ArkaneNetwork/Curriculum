#!/usr/bin/env bash

docker run -v $(pwd):/tmp mythril/myth -x /tmp/Underflow.sol