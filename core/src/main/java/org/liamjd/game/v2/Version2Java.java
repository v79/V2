package org.liamjd.game.v2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Version2Java extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;

    @Override
    public void create() {
        stage = new Stage(new FitViewport(640, 480));
        skin = new Skin(Gdx.files.internal("ui/skin.json"));

        Window window = new Window("Example screen", skin, "border");
        window.defaults().pad(4f);
        window.add("This is a simple Scene2D view.").row();
        final TextButton button = new TextButton("Click me!", skin);
        button.pad(8f);
        button.addListener(new ChangeListener() {
            @Override
            public void changed(final ChangeEvent event, final Actor actor) {
                button.setText("Clicked.");
            }
        });
        window.add(button);
        window.pack();
        window.setPosition(stage.getWidth() / 2f - window.getWidth() / 2f,
                stage.getHeight() / 2f - window.getHeight() / 2f);
        window.addAction(Actions.sequence(Actions.alpha(0f), Actions.fadeIn(1f)));
        stage.addActor(window);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
