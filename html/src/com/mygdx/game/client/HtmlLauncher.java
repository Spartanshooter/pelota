package com.mygdx.game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.mygdx.game.pelota;

public class HtmlLauncher extends GwtApplication {
        @Override
        public GwtApplicationConfiguration getConfig () {
                // Resizable application, uses available space in browser
                GwtApplicationConfiguration config = new GwtApplicationConfiguration();
                return new GwtApplicationConfiguration(true);
                // Fixed size application:
                //return new GwtApplicationConfiguration(480, 320);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new pelota();
        }
}