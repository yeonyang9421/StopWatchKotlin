package kr.co.woobi.imyeon.stopwatchkotlin.flashLight

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import kr.co.woobi.imyeon.stopwatchkotlin.R

/**
 * Implementation of App Widget functionality.
 */
class FlashAppWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(
                context,
                appWidgetManager,
                appWidgetId
            )
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    companion object {

        internal fun updateAppWidget(
            context: Context, appWidgetManager: AppWidgetManager,
            appWidgetId: Int
        ) {

            val widgetText = context.getString(R.string.appwidget_text)
            // Construct the RemoteViews object
            val views = RemoteViews(context.packageName,
                R.layout.flash_app_widget
            )
            views.setTextViewText(R.id.appwidget_text, widgetText)

            //추가되는 부분
            val intent= Intent(context, FlashService::class.java)
            val pendingIntent= PendingIntent.getService(context, 0, intent,0)

            //위젯을 클릭하면 위에서 정의한 intent 실행
            views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent)


            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

