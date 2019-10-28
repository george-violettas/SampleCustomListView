package codes.sample.samplecustomlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListViewAdapterNameAndAge extends BaseAdapter {

    private ArrayList<NameAndAgeClass> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListViewAdapterNameAndAge(Context context, ArrayList<NameAndAgeClass> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //      int type = getItemViewType(position);

        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.row_layout, null);
            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.nameTextView);
            holder.age = (TextView) convertView.findViewById(R.id.ageTextView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(listData.get(position).getName());

        //okay this is important, since the return value of getAge is an integer
        //you have to cast it as String first, cuz otherwise Android will look for resource number 0-9 (based on getAge's value)
        holder.age.setText(String.valueOf(listData.get(position).getAge()));

        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView age;
    }

}
