package ws.mahesh.cwc2015lite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;
import ws.mahesh.cwc2015lite.fragments.ContactFragment;
import ws.mahesh.cwc2015lite.fragments.FixturesFragment;
import ws.mahesh.cwc2015lite.fragments.TeamsFragment;
import ws.mahesh.cwc2015lite.fragments.VenueFragment;


public class MainActivity extends MaterialNavigationDrawer {

    MaterialSection teamsSection, fixtureSection, venueSection, contactSection;

    @Override
    public void init(Bundle savedInstanceState) {
        allowArrowAnimation();
        this.setDrawerHeaderImage(this.getResources().getDrawable(R.drawable.banner_1));

        teamsSection = this.newSection("Teams", this.getResources().getDrawable(R.drawable.ic_group_black_24dp), new TeamsFragment()).setSectionColor(getResources().getColor(R.color.colorTeams));
        fixtureSection = this.newSection("Fixtures", this.getResources().getDrawable(R.drawable.ic_event_black_24dp), new FixturesFragment()).setSectionColor(getResources().getColor(R.color.colorFixtures));
        venueSection = this.newSection("Venues", this.getResources().getDrawable(R.drawable.ic_public_black_24dp), new VenueFragment()).setSectionColor(getResources().getColor(R.color.colorVenue));

        contactSection = this.newSection("Email Us", this.getResources().getDrawable(R.drawable.ic_mail_black_24dp), new ContactFragment()).setSectionColor(getResources().getColor(R.color.colorTeams));


        this.addSection(fixtureSection);
        this.addSection(teamsSection);
        this.addSection(venueSection);

        this.addBottomSection(contactSection);

        this.setBackPattern(MaterialNavigationDrawer.BACKPATTERN_BACK_TO_FIRST);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
                String sAux = "\nStay up to date on Cricket World Cup 2015!\n\n Note: No ads and no permissions required to install, we promote privacy\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=ws.mahesh.cwc2015lite \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "Share using"));
            } catch (Exception e) { //e.toString();
            }
        }

        return super.onOptionsItemSelected(item);
    }

}