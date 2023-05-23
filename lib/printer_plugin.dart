
import 'package:flutter/services.dart';

import 'printer_plugin_platform_interface.dart';

class PrinterPlugin {
  static const MethodChannel _channel = MethodChannel('printer_plugin');

  Future<String?> getPlatformVersion() {
    return PrinterPluginPlatform.instance.getPlatformVersion();
  }

  static Future<String?> printTicket(String content) async {
    try {
      final String? result = await _channel.invokeMethod('printTicket', content);
      return result;
    } on PlatformException catch (e) {
      return 'Failed to print ticket: ${e.message}';
    }
  }
}
