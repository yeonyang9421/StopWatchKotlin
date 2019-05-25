package kr.co.woobi.imyeon.stopwatchkotlin.flashLight;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import kr.co.woobi.imyeon.stopwatchkotlin.R;

/**
 * Implementation of App Widget functionality.
 */
public class TorchAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.torch_app_widget_with_java);
        views.setTextViewText(R.id.appwidget_text, widgetText);


        //===============================================================새로 추가된 부분
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context, 0, new Intent(context, TorchReceiver.class), 0);
        views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);
        //===============================================================새로 추가된 부분

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

