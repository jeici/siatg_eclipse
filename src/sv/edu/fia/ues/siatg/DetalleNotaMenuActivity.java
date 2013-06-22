package sv.edu.fia.ues.siatg;



import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DetalleNotaMenuActivity extends ListActivity {

	String[] menu={"Insertar Registro","Eliminar Registro","Consultar Registro", "Actualizar Registro"};
    String[] activities={"DetalleNotaInsertarActivity","DetalleNotaEliminarActivity","DetalleNotaConsultarActivity", "DetalleNotaActualizarActivity"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, menu));
        
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(0, 128, 64));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }
    
    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
    	super.onListItemClick(l, v, position, id);
    		
    	String nombreValue=activities[position];
    	
    	l.getChildAt(position).setBackgroundColor(Color.rgb(0, 128, 64));
    	
    	try{
    		Class<?> clase=Class.forName("sv.edu.fia.ues.siatg."+nombreValue);
    		Intent inte = new Intent(this,clase);
    		this.startActivity(inte);
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}	
    }
}
