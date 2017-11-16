package com.example.ahsan.hciproject.Activity;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.View;

import com.example.ahsan.hciproject.Adapter.CartListAdapter;
import com.example.ahsan.hciproject.R;
import com.example.ahsan.hciproject.entity.CartItem;
import com.example.ahsan.hciproject.util.RecylerItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements RecylerItemTouchHelper.RecyclerItemTouchHelperListener {
    private static final String TAG = CartActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<CartItem> cartList;
    private CartListAdapter mAdapter;
    private CoordinatorLayout coordinatorLayout;

    // url to fetch menu json
    private static final String URL = "https://api.androidhive.info/json/menu.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

//
//            Toolbar toolbar = findViewById(R.id.toolbar);
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setTitle(getString(R.string.my_cart));
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            recyclerView = findViewById(R.id.recycler_view);
            coordinatorLayout = findViewById(R.id.coordinator_layout);
            cartList = new ArrayList<>();
            mAdapter = new CartListAdapter(this, cartList);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(mAdapter);

            // adding item touch helper
            // only ItemTouchHelper.LEFT added to detect Right to Left swipe
            // if you want both Right -> Left and Left -> Right
            // add pass ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT as param
            ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecylerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
            new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);


            // making http call and fetching menu json
            prepareCart();
        }

        /**
         * method make volley network call and parses json
         */
    private void prepareCart() {
        cartList.add(new CartItem(1,"Salmon Teriyaki","Roasted salon dumped in soa sauce and mint",140,"https://api.androidhive.info/images/food/1.jpg"));
        cartList.add(new CartItem(2,"Grilled Mushroom and Vegetables","Spcie grills mushrooms, cucumber, apples and lot more",150,"https://api.androidhive.info/images/food/2.jpg"));
        cartList.add(new CartItem(3,"Chicken Overload Meal","Grilled chicken & tandoori chicken in masala curry",185,"https://api.androidhive.info/images/food/3.jpg"));
        cartList.add(new CartItem(4,"Chinese Egg Fry","Exotic eggs Fried served steaming hot",250,"https://api.androidhive.info/images/food/4.jpg"));
        cartList.add(new CartItem(5,"Chicken Wraps","Grilled chicken tikka rool wrapped",140,"https://api.androidhive.info/images/food/5.jpg"));

    }

    /**
     * callback when recycler view is swiped
     * item will be removed on swiped
     * undo option will be provided in snackbar to restore the item
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof CartListAdapter.MyViewHolder) {
            // get the removed item name to display it in snack bar
            String name = cartList.get(viewHolder.getAdapterPosition()).getName();

            // backup of removed item for undo purpose
            final CartItem deletedItem = cartList.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            mAdapter.removeItem(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, name + " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    mAdapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }


}