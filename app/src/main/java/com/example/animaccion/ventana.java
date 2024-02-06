package com.example.animaccion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class ventana extends View {
    Paint pintar = new Paint();
    int x=0 , y=0;
    boolean dirx=true , diry=true;
    Color propio;


    public ventana(Context context) {
        super(context);
        propio=new Color();
    }

    @Override
    public void onDraw(Canvas canvas) {
        Path path = new Path(); //triangulo
        int radio = 90;

        try {
            //canvas.drawCircle(x,y,radio, pintar); //curculo
            //canvas.drawRect(x-100, y-100, x+100, y+100,pintar); //cuadrado

            path.moveTo(x + canvas.getWidth() / 12 , y - 100); // punta arriba
            path.lineTo(x - 100 + canvas.getWidth() / 12 , y + 100); // punta derecha
            path.lineTo(x + 100 + canvas.getWidth() / 12 , y + 100); // punta izquierda

            /*
            path.moveTo(canvas.getWidth() / 2, 500);
            path.lineTo(canvas.getWidth() / 2 + 100, 700);
            path.lineTo(canvas.getWidth() / 2 - 100, 700);

            canvas.drawPath(path, pintar);
            */
            pintar.setColor(Color.RED);

            if (x<0){ //izquierdo fondo blanco y pelota cuadrada
                setBackgroundColor(Color.WHITE);
                //canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                dirx = true;

                //pintar.setColor(Color.BLACK);
            }

            if (x>canvas.getWidth()){ //derecho fondo negro y pelota circulo
                setBackgroundColor(Color.BLACK);
                dirx=false;

                //pintar.setColor(Color.WHITE);
            }

            if (y<0){//arriba fondo azul y trinagulo
                setBackgroundColor(Color.BLUE);
                diry=true;

                //pintar.setColor(Color.YELLOW);
            }

            if (y>canvas.getHeight()){//abajo fondo naranja y circulo
                setBackgroundColor(Color.YELLOW);
                diry=false;

                //pintar.setColor(Color.BLUE);
            }

            //Velocidad
            /*
            if (dirx ==true){
                x=x+3;
            }else {
                x=x-3;
            }if(diry==true){
                y=y+3;
            }else {
                y=y-3;
            }
            */

            if (dirx ==true){
                x=x+5;
                canvas.drawRect(x-100, y-100, x+100, y+100,pintar); //cuadrado
            }else {
                x=x-5;
                canvas.drawCircle(x,y,radio, pintar); //curculo
            }if(diry==true){
                y=y+5;
                canvas.drawPath(path, pintar); //triangulo
            }else {
                y=y-5;
                canvas.drawCircle(x,y,radio, pintar); //curculo
            }


            Thread.sleep(3);
            invalidate();
        }catch(Exception e){
            Toast.makeText(null, e.toString(), Toast.LENGTH_LONG).show();
        }



    }
}
