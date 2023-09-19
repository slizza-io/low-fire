package io.slizza.lowfire;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;

@ConfigName("settings")
public class LowFireConfiguration extends AddonConfig {

  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);
  @SliderSetting(steps=0.05F, min=0, max=1F)
  private final ConfigProperty<Float> fireSize = new ConfigProperty<>(0.25F);

  public ConfigProperty<Float> getFireSize() {
    return fireSize;
  }

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }
}
