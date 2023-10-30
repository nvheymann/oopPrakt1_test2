package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FReizeitbaederModel {
	private Freizeitbad bad;

	public Freizeitbad getBad() {
		return bad;
	}

	public void setBad(Freizeitbad bad) {
		this.bad = bad;
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException
	// Werfen einer IOException
	{
	 BufferedWriter aus = new BufferedWriter(
	new FileWriter("Freizeitbaeder.csv", true));
	 aus.write(this.getBad().gibFreizeitbadZurueck(';'));
	aus.close();
	}
}
