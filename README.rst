==================
UDOO ADK Lightbulb
==================

This project is developed for educational purpose. It shows how you can easily implement an ADK
project using an ADK wrapper.

External dependencies
---------------------

* `ADK Toolkit`_

Configuration
-------------

This project uses **ADK Toolkit** to manage *UsbManager* and *UsbAccessory*. You only need a couple
of lines on your project to use ADK features:

.. code-block:: java

    private AdkManager mAdkManager;
    mAdkManager = new AdkManager((UsbManager) getSystemService(Context.USB_SERVICE));

Interactions
------------

When you click on the lightbulb image, ADK Toolkit send a command to Arduino. Available commands are:

* bulbOff(): ``adkManager.sendText("0")``
* bulbOn(): ``adkManager.sendText("1")``

No more!

Changelog
---------

0.1.1 [2014-03-10]
~~~~~~~~~~~~~~~~~~

* Updated Gradle plugin
* Removed all ADK source code in favor of `ADK Toolkit`_

.. _ADK Toolkit: https://github.com/palazzem/adk-toolkit

0.1.0 [2014-01-19]
~~~~~~~~~~~~~~~~~~

* AdkManager: write wrapper
* Removed complex UI for better code readability

License
-------

* Android app: FreeBSD
* UDOO logo: `Copyright 2013 SECO USA Inc`_

.. _Copyright 2013 SECO USA Inc: http://www.udoo.org/
