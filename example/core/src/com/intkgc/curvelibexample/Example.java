package com.intkgc.curvelibexample;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.intkgc.curve.config.Settings;

public class Example extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        FileHandle settingsFile = Gdx.files.external("CurveTest/settings.json");
        if (!settingsFile.exists()) settingsFile.writeString("{}", false);
        Settings.load(settingsFile, SettingsExample.class);
        SettingsExample.testBoolean = true;
        Settings.save(settingsFile, SettingsExample.class);

        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
