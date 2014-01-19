==================
UDOO ADK Lightbulb
==================

This project is developed for educational purpose. It shows how you can easily implement an ADK
project using an *AdkManager*.

Documentation: Not available now.

Configuration
-------------

This project uses AdkManager to manage *UsbManager* and *UsbAccessory*. You only need to add these
lines on your project to use some (for now) ADK features:

.. code-block:: java

    private AdkManager mAdkManager;
    // ...
    mAdkManager = new AdkManager((UsbManager) getSystemService(Context.USB_SERVICE));
    registerReceiver(mAdkManager.getUsbReceiver(), mAdkManager.getDetachedFilter());

Registered Broadcast Receiver is required to close Android Open Accessory protocol if
*UsbManager.ACTION_USB_ACCESSORY_DETACHED* event is found (if someone unplug USB connection).

It's a good idea to override *onDestroy()* and unregister this Broadcast Receiver:

.. code-block:: java

    unregisterReceiver(mAdkManager.getUsbReceiver());

Interactions
------------

AdkManager exposes these interfaces:

.. code-block:: java

    // ADK protocol
    void readText();                    // Not implemented now
    void sendText(String text);

    // Activity related interfaces
    void closeAdk();                    // Use it in onPause()
    void resumeAdk();                   // Use it in onResume()

To write something on your accessory, simply use:

.. code-block:: java

    adkManager.sendText("Hello world!");

*readText* is not currently implemented because it's not required for this ADK Hello World.

Roadmap
-------

AdkManager will be converted into an external **library** so you can easily import it in your
project as a **gradle dependency**.

Changelog
---------

0.1.0 [2014-01-19]
~~~~~~~~~~~~~~~~~~

* AdkManager: write wrapper
* Removed complex UI for better code readability

0.0.0 [2014-01-14]
~~~~~~~~~~~~~~~~~~

* Ignition

License
-------

* Android software: FreeBSD
* UDOO logo: `Copyright 2013 SECO USA Inc`_

.. _Copyright 2013 SECO USA Inc: http://www.udoo.org/
