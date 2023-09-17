package io.slizza.lowfire;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class LowFireAddon extends LabyAddon<LowFireConfiguration> {

  private static LowFireAddon instance;

  public LowFireAddon() {
    instance = this;
  }

  public static LowFireAddon get() {
    return instance;
  }

  @Override
  protected void enable() {
    this.registerSettingCategory();
  }

  @Override
  protected Class<LowFireConfiguration> configurationClass() {
    return LowFireConfiguration.class;
  }
}
