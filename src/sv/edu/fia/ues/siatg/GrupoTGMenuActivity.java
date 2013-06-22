package sv.edu.fia.ues.siatg;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GrupoTGMenuActivity extends ListActivity {

	
		String[] menu={"Insertar GrupoTG","Eliminar GrupoTG","Consultar GrupoGT","Actualizar Registro"};
		String[] activities={"GrupoTGInsertarActivity","GrupoTGEliminarActivity","GrupoTGConsultarActivity","GrupoTGActualizarActivity"};
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			ListView listView = getListView();
			listView.setBackgroundColor(Color.rgb(255, 255, 255));
			
			ArrayAdapter<String> adapter = new
	ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
			setListAdapter(adapter);
	}
		
		@Override
		protected void onListItemClick(ListView l,View v,int position,long id){
			super.onListItemClick(l, v, position, id);
			
			String nombreValue=activities[position];

			l.getChildAt(position).setBackgroundColor(Color.rgb(128, 128, 255));
			try{
				Class<?> clase=Class.forName("sv.edu.fia.ues.siatg."+nombreValue);
				Intent inte = new Intent(this,clase);
				this.startActivity(inte);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}
	}

	
