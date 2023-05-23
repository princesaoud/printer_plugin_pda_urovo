# printer_plugin

A new Flutter plugin project.

## Getting Started

 

# printer_plugin_example

Demonstrates how to use the printer_plugin plugin.

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
}
