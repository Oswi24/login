package mx.edu.tesoem.login;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Pantalla de inicio de sesión. SOLO DISEÑO: no hay conexión a base de datos
 * ni a un servidor. La validación únicamente comprueba que los campos tengan
 * un formato correcto, para mostrar los estados de error de Material 3.
 */
public class LoginActivity extends AppCompatActivity {

    private TextInputLayout tilCorreo, tilContrasena;
    private TextInputEditText etCorreo, etContrasena;
    private MaterialCheckBox cbRecordarme;
    private MaterialButton btnIngresar, btnGoogle;
    private View raiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        raiz = findViewById(R.id.raiz);
        tilCorreo = findViewById(R.id.til_correo);
        tilContrasena = findViewById(R.id.til_contrasena);
        etCorreo = findViewById(R.id.et_correo);
        etContrasena = findViewById(R.id.et_contrasena);
        cbRecordarme = findViewById(R.id.cb_recordarme);
        btnIngresar = findViewById(R.id.btn_ingresar);
        btnGoogle = findViewById(R.id.btn_google);

        btnIngresar.setOnClickListener(v -> validarFormulario());
        btnGoogle.setOnClickListener(v -> mostrarMensaje(getString(R.string.msg_demo)));
        findViewById(R.id.tv_olvidaste).setOnClickListener(
                v -> mostrarMensaje(getString(R.string.msg_demo)));
        findViewById(R.id.tv_registro).setOnClickListener(
                v -> mostrarMensaje(getString(R.string.msg_demo)));
    }

    /** Valida formato (no credenciales) y muestra errores en cada campo. */
    private void validarFormulario() {
        String correo = etCorreo.getText() == null ? "" : etCorreo.getText().toString().trim();
        String clave = etContrasena.getText() == null ? "" : etContrasena.getText().toString();
        boolean valido = true;

        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            tilCorreo.setError(getString(R.string.error_correo));
            valido = false;
        } else {
            tilCorreo.setError(null);
        }

        if (clave.length() < 6) {
            tilContrasena.setError(getString(R.string.error_contrasena));
            valido = false;
        } else {
            tilContrasena.setError(null);
        }

        if (valido) {
            mostrarMensaje(getString(R.string.msg_ok));
        }
    }

    private void mostrarMensaje(String texto) {
        Snackbar.make(raiz, texto, Snackbar.LENGTH_SHORT).show();
    }
}
