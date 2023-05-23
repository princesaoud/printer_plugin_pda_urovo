package com.example.printer_plugin;

import android.device.PrinterManager;
import android.os.Handler;
import android.util.Log;

public class PrinterManagerWrapper {

    private static final String TAG = "PrinterManagerWrapper";
    private PrinterManager mPrinterManager;
    private Handler mPrinterHandler;

    public void printTicket(String content) {
        mPrinterManager = getPrinterManager();
        int status = mPrinterManager.getStatus();
        Log.d(TAG, "Printer status: " + status);

        if (status == PrinterManager.PRNSTS_OK) {
            mPrinterManager.setupPage(384, -1); // Set paper size

            String fontName = "simsun";
            int fontSize = 24;
            int fontStyle = 0x0000;

            int lineHeight = (int) (fontSize * 1.2); // Adjust the multiplier as needed
            int height = 0;
//            String[] texts = content.split("\n");
            String[] texts = content.split("/");
            for (String text : texts) {

                height += lineHeight;
                while (text.length() > 0) {
                    int charsPrinted = mPrinterManager.drawText(text, 0, height, fontName, fontSize, false, false, 0);

                    if (charsPrinted >= text.length()) {
                        break;
                    }
                    text = text.substring(charsPrinted + 1);
                    height += lineHeight;
                }
            }
            int marginHeight = height + 50; // 20 is the desired margin height
            mPrinterManager.drawLine(0, marginHeight, 384, marginHeight, 2);
//
            int printResult = mPrinterManager.printPage(0); // Print the page
//            int printResult = 0; // Print the page

            if (printResult == PrinterManager.PRNSTS_OK) {
                Log.d(TAG, "Printing successful");
            } else {
                Log.d(TAG, "Printing failed with error code: " + printResult);
            }

            mPrinterManager.paperFeed(20); // Paper feed
        } else {
            Log.d(TAG, "Printer is not ready");
        }
    }

    private PrinterManager getPrinterManager() {
        if (mPrinterManager == null) {
            mPrinterManager = new PrinterManager();
            mPrinterManager.open();
        }
        return mPrinterManager;
    }
}
