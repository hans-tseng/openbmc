# Copyright 2018-present Facebook. All Rights Reserved.

inherit aspeed_uboot_image

require recipes-core/images/fb-openbmc-image.bb

# Changing the image compression from gz to lzma achieves 30% saving (~3M).
IMAGE_FSTYPES += "cpio.lzma.u-boot"
UBOOT_IMAGE_ENTRYPOINT = "0x80800000"

# Include modules in rootfs
IMAGE_INSTALL += " \
  packagegroup-openbmc-base \
  packagegroup-openbmc-net \
  packagegroup-openbmc-python3 \
  packagegroup-openbmc-rest3 \
  at93cx6-util \
  ast-mdio \
  bcm5396-util \
  bic-util \
  bitbang \
  cpldupdate \
  flashrom \
  front-paneld \
  fscd \
  fw-util \
  gpiod \
  ipmbd \
  ipmid \
  libcpldupdate-dll-echo \
  libcpldupdate-dll-gpio \
  lldp-util \
  log-util \
  m95m02-util \
  mterm \
  openbmc-gpio \
  openbmc-utils \
  sensor-setup \
  sensor-mon \
  spatula \
  trousers \
  tpm-tools \
  usb-console \
  watchdog-ctrl \
  wedge-eeprom \
  "
IMAGE_FEATURES += " \
  ssh-server-openssh \
  tools-debug \
  "

DISTRO_FEATURES += " \
  ext2 \
  ipv6 \
  nfs \
  usbgadget \
  usbhost \
  "
