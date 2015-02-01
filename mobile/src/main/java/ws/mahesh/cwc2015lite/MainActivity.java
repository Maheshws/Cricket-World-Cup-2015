package ws.mahesh.cwc2015lite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;
import ws.mahesh.cwc2015lite.fragments.FixturesFragment;
import ws.mahesh.cwc2015lite.fragments.TeamsFragment;
import ws.mahesh.cwc2015lite.fragments.VenueFragment;


public class MainActivity extends MaterialNavigationDrawer {

    MaterialSection teamsSection, fixtureSection, venueSection,contactSection, recorder, night, last;

    @Override
    public void init(Bundle savedInstanceState) {
        allowArrowAnimation();
        this.setDrawerHeaderImage(this.getResources().getDrawable(R.drawable.banner_1));


        // create sections

        teamsSection = this.newSection("Teams", this.getResources().getDrawable(R.drawable.ic_group_black_24dp), new TeamsFragment()).setSectionColor(getResources().getColor(R.color.colorTeams));
        fixtureSection = this.newSection("Fixtures", this.getResources().getDrawable(R.drawable.ic_event_black_24dp), new FixturesFragment()).setSectionColor(getResources().getColor(R.color.colorFixtures));
        venueSection = this.newSection("Venues", this.getResources().getDrawable(R.drawable.ic_public_black_24dp), new VenueFragment()).setSectionColor(getResources().getColor(R.color.colorVenue));
        /* teamsSection = this.newSection("Section 2",new MaterialSectionListener() {
            @Override
            public void onClick(MaterialSection section) {
                Toast.makeText(NavigationDrawerActivityRipple.this, "Section 2 Clicked", Toast.LENGTH_SHORT).show();

                // deselect section when is clicked
                section.unSelect();
            }
        });
        // recorder section with icon and 10 notifications
        recorder = this.newSection("Recorder",this.getResources().getDrawable(R.drawable.ic_mic_white_24dp),new FragmentIndex()).setNotifications(10);
        // night section with icon, section color and notifications
        night = this.newSection("Night Section", this.getResources().getDrawable(R.drawable.ic_hotel_grey600_24dp), new FragmentIndex())
                .setSectionColor(Color.parseColor("#2196f3"),Color.parseColor("#1565c0")).setNotifications(150);
        // night section with section color
        last = this.newSection("Last Section", new FragmentButton()).setSectionColor(Color.parseColor("#ff9800"), Color.parseColor("#ef6c00"));

        Intent i = new Intent(this,ContactsContract.Profile.class);
        */
        contactSection = this.newSection("Email Us", this.getResources().getDrawable(R.drawable.ic_mail_black_24dp), new ContactFragment()).setSectionColor(getResources().getColor(R.color.colorTeams));

        // add your sections to the drawer
        this.addSection(fixtureSection);
        this.addSection(teamsSection);
        this.addSection(venueSection);
        /*this.addSubheader("Subheader");
        this.addSection(recorder);
        this.addSection(night);
        this.addDivisor();
        this.addSection(last);
        */

        this.addBottomSection(contactSection);

        this.setBackPattern(MaterialNavigationDrawer.BACKPATTERN_BACK_TO_FIRST);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_open_playstore) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:" + "Maxx")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/search?q=pub:" + "Maxx")));
            }
            return true;
        }
        if (id == R.id.action_share_link) {
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Cricket World Cup 15");
                String sAux = "\nAds free World Cup 2015 App, requires no permissions to install\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=ws.mahesh.cwc2015lite \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "Share using"));
            } catch (Exception e) { //e.toString();
            }
        }

        return super.onOptionsItemSelected(item);
    }

}