package mx.edu.tesoem.login;

import android.app.Application;

import com.google.android.material.color.DynamicColors;

/**
 * Clase Application: se ejecuta una sola vez al iniciar el proceso.
 * Activa Material You (color dinámico): la paleta se toma del fondo de
 * pantalla del dispositivo (Android 12 / API 31 o superior). En versiones
 * anteriores se usa la paleta definida en el tema (themes.xml).
 */
public class LoginApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}
