package harry.table;

/**
 * Created by Harpratap on 13-02-2015.
 */
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
public class DbMain extends ListActivity {
    private Cursor employees;
    private MyDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new MyDatabase(this);
        employees = db.getEmployees(); // you would not typically call this on the main thread
        ListAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                employees,
                new String[] {"LastName"},
                new int[] {android.R.id.text1});
        getListView().setAdapter(adapter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        employees.close();
        db.close();
    }
}
