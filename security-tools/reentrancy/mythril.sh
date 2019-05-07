#!/usr/bin/env bash

docker run -v $(pwd):/tmp mythril/myth -x /tmp/HoneyPot.sol --solv 0.4.25