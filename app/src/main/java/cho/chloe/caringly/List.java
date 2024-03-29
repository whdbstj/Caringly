package cho.chloe.caringly;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        ListView listview = findViewById(R.id.listView);
        ListViewAdapter adapter = new ListViewAdapter();

        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new Item("1", "UNIVERSITY OF MARYLAND GLOBAL CAMPUS", "https://www.umgc.edu/blog/flexible-education-students-disabilities"));
        adapter.addItem(new Item("2", "Best Universities", "https://best-universities.net/resources/online-college-learning-for-students-with-disabilities/"));
        adapter.addItem(new Item("3", "Montclair State University", "https://www.montclair.edu/online/virtual-learning-for-students-with-disabilities-certificate-online/"));
        adapter.addItem(new Item("4", "Online Bachelor Degrees", "https://www.online-bachelor-degrees.com/online-learning-benefits-disabled-student/"));
        adapter.addItem(new Item("5", "IDEA", "https://sites.ed.gov/idea/"));



        //리스트뷰에 Adapter 설정
        listview.setAdapter(adapter);
    }

    public class ListViewAdapter extends BaseAdapter {
        ArrayList<Item> items = new ArrayList<Item>();

        public void addItem(Item item) {
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final Item item = items.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // listitem layout을 inflate 해준다.(memory에 올려준다)
            convertView = inflater.inflate(R.layout.listitem_layout, viewGroup, false);

            TextView tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);

            tv_num.setText(item.getNum());
            tv_name.setText(item.getName());

            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, item.getNum()+" "+item.getName()+" clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
                    startActivity(intent);
                }
            });

            return convertView;  //뷰 객체 반환
        }
    }
}
