package dev.bc4.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario){

        ImageView imagemResultado = findViewById(R.id.escolhaApp);
        TextView txtResultado = findViewById(R.id.txtResultado);

        int numero = new Random().nextInt(3);

        String[] ppt = {"pedra","papel","tesoura"};
        String opcaoApp = ppt[numero];

        switch (opcaoApp){
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (opcaoApp == "tesoura" && opcaoUsuario == "papel") ||
                (opcaoApp == "papel" && opcaoUsuario == "pedra") ||
                (opcaoApp == "pedra" && opcaoUsuario == "tesoura")

        ){
            txtResultado.setText("Você perdeu 🤣");
        }else if(
                (opcaoUsuario == "tesoura" && opcaoApp == "papel") ||
                (opcaoUsuario == "papel" && opcaoApp == "pedra") ||
                (opcaoUsuario == "pedra" && opcaoApp == "tesoura")
        ){
            txtResultado.setText("Você ganhou! 😒");
        }else{
            txtResultado.setText("Empatamos!");

        }

    }
}
