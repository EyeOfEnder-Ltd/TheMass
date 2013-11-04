package com.eyeofender.themass.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import com.eyeofender.themass.TheMass;

public class EnvironmentListener implements Listener{

	private TheMass plugin;
	
	public EnvironmentListener(TheMass plugin){
		this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onWeatherUpdate(WeatherChangeEvent event) {
		if (event.toWeatherState() && !plugin.getConfig().getBoolean("weather-enabled")){
			event.setCancelled(true);
		}
	}
}
