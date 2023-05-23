# printer_plugin_example

Demonstrates how to use the printer_plugin plugin.

## Getting Started

This project is a starting point for a Flutter application.

A few resources to get you started if this is your first Flutter project:

- [Lab: Write your first Flutter app](https://docs.flutter.dev/get-started/codelab)
- [Cookbook: Useful Flutter samples](https://docs.flutter.dev/cookbook)

For help getting started with Flutter development, view the
[online documentation](https://docs.flutter.dev/), which offers tutorials,
samples, guidance on mobile development, and a full API reference.

Example snippet:

import 'package:flutter/material.dart';
import 'package:printer_plugin/printer_plugin.dart';

void main() {
runApp(const MyApp());
}

class MyApp extends StatefulWidget {
const MyApp({super.key});

@override
    _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
    @override
    Widget build(BuildContext context) {
        TextEditingController controller = TextEditingController();
    return MaterialApp(
        home: Scaffold(
            appBar: AppBar(
            title: const Text('Printer Plugin Example'),
    ),
    body: Center(
        child: Column(
            children: [
                TextFormField(controller: controller,),
                ElevatedButton(
                    child: const Text('Print Ticket'),
                        onPressed: () {
                            PrinterPlugin.printTicket('${controller.text}');
// By using '/' you break the line, so the upcoming text go to the next line;
                        },
                    ),
                ],
                    ),
                ),
            ),
        );
    }
}
