package pa.pacasian.sumithkumar.attendenceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sunith on 15-10-2017.
 */

public class GridAdapter extends BaseAdapter {
    Context context;
    String []name1;
    int[] imv;
    LayoutInflater inflater;
    public GridAdapter(Context context,String[] name1,int[] imv){
        this.context=context;
        this.name1=name1;
        this.imv=imv;
    }
    @Override
    public int getCount() {
        return name1.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView gridtext;
        ImageView image;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemBiew=inflater.inflate(R.layout.item_for_grid,parent,false);
        gridtext=(TextView)itemBiew.findViewById(R.id.txt);
        image=(ImageView)itemBiew.findViewById(R.id.imb);
        gridtext.setText(name1[position]);
        image.setImageResource(imv[position]);
        return itemBiew;
    }
}
