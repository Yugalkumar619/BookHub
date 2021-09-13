package com.yugal.bookhub.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yugal.bookhub.R
import com.yugal.bookhub.adapter.DashboardRecyclerAdapter
import com.yugal.bookhub.model.Book
import com.yugal.bookhub.util.ConnectionManager
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var recyclerDashboard: RecyclerView

    private lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var btnCheckInternet: Button

    private val bookList = arrayListOf(
        "Rich Dad Poor Dad",
        "As a man think",
        "Be Obsessed or Be Average",
        "7 habits of highly effective people",
        "10 X rule",
        "The Rudest Book Ever",
        "Elon Musk",
        "How to win friends and influence people",
        "48 Laws of power",
        "Think and grow rich",
        "The complete idiots"
    )

    private lateinit var recyclerAdapter: DashboardRecyclerAdapter

    val bookInfoList = arrayListOf<Book>(
        Book("Rich Dad Poor Dad","Robert Kiyosaki","23$","4.6",R.drawable.richdad),
        Book("As a man think","James Allon","16$","4.1",R.drawable.as_a_man_thinketh),
        Book("Be Obsessed or Be Average","Grant Cardone", "35$","4.9",R.drawable.boba),
        Book("7 habits of highly effective people","Jon Moxley","14$","3.8",R.drawable.habits_of_highly_effective_people),
        Book("10 X Rule","Grant Cardone","45$","5.0",R.drawable.x_10_rule),
        Book("The Rudest Book Ever","Shwetaab Gangwar","15$","4.4",R.drawable.the_rudest_book_ever),
        Book("Elon Musk","Dino Elon","30$","4.6",R.drawable.elon_musk),
        Book("How to win friends and influence people","Dale Carnagi","27$","4.2",R.drawable.how_to_win_friends_and_infuence_people)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)

        btnCheckInternet = view.findViewById(R.id.btnCheckInternet)

        btnCheckInternet.setOnClickListener{
            if(ConnectionManager().checkConnectivity(activity as Context)){
                // Internet is not available
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Internet Connection Found")
                dialog.setPositiveButton("Ok"){text, listener ->
                    //Do nothing
                }
                dialog.setNegativeButton("Cancel"){text, listerner ->
                    //Do nothing
                }
                dialog.create()
                dialog.show()
            }else{
                // Internet is not available
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Error")
                dialog.setMessage("Internet Connection is not Found")
                dialog.setPositiveButton("Ok"){text, listener ->
                    //Do nothing
                }

                dialog.setNegativeButton("Cancel"){text, listener ->
                    //Do nothing
                }
                dialog.create()
                dialog.show()
            }
        }

        layoutManager = LinearLayoutManager(activity)

        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)

        recyclerDashboard.adapter = recyclerAdapter

        recyclerDashboard.layoutManager = layoutManager

        recyclerDashboard.addItemDecoration(DividerItemDecoration(
            recyclerDashboard.context,
            (layoutManager as LinearLayoutManager).orientation
        ))

        return view
    }


}