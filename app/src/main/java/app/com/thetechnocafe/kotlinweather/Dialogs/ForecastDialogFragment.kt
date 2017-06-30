package app.com.thetechnocafe.kotlinweather.Dialogs

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import app.com.thetechnocafe.kotlinweather.Models.Forecast
import app.com.thetechnocafe.kotlinweather.R
import app.com.thetechnocafe.kotlinweather.Utils.WeatherToImage

/**
 * Created by gurleensethi on 28/06/17.
 */
class ForecastDialogFragment : DialogFragment() {

    private var mWeatherImageView: ImageView? = null
    private var mHighTemperatureTextView: TextView? = null
    private var mLowTemperatureTextView: TextView? = null
    private var mTextTemperatureTextView: TextView? = null
    private var mDayTextView: TextView? = null
    private var mCloseImageView: ImageView? = null

    companion object {
        private val ARGS_FORECAST = "args_forecast"

        fun getInstance(forecast: Forecast): ForecastDialogFragment {
            val bundle = Bundle()
            bundle.putSerializable(ARGS_FORECAST, forecast)

            val fragment = ForecastDialogFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.dialog_forecast_info, container, false)

        mWeatherImageView = view?.findViewById(R.id.weather_image_view) as ImageView
        mHighTemperatureTextView = view.findViewById(R.id.high_temperature_text_view) as TextView
        mLowTemperatureTextView = view.findViewById(R.id.low_temperature_text_view) as TextView
        mTextTemperatureTextView = view.findViewById(R.id.weather_condition_text_view) as TextView
        mDayTextView = view.findViewById(R.id.day_text_view) as TextView
        mCloseImageView = view.findViewById(R.id.close_image_view) as ImageView

        initViews()

        return view
    }

    override fun onResume() {
        super.onResume()
        dialog.window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
    }

    private fun initViews() {
        val forecast = arguments.getSerializable(ARGS_FORECAST) as Forecast
        mWeatherImageView?.setImageResource(WeatherToImage.getImageForCode(forecast.code))
        mHighTemperatureTextView?.text = forecast.high
        mLowTemperatureTextView?.text = forecast.low
        mTextTemperatureTextView?.text = forecast.text
        mDayTextView?.text = forecast.day

        mCloseImageView?.setOnClickListener {
            view ->
            dismiss()
        }
    }
}