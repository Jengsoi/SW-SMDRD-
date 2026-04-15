package PokemonController;

import java.util.ArrayList;

import PokemonDTO.MusicDTO;
import javazoom.jl.player.MP3Player;

public class MusicCon {
	 MP3Player mp = new MP3Player();
	    ArrayList<MusicDTO> musiclist = new ArrayList<MusicDTO>();
	    int i = 0;
	    public MusicCon() {
	        String mpath = "C:\\Users\\SMHRDH\\Desktop\\Dmusic\\";
	        musiclist.add(new MusicDTO(mpath + "BattleLose.mp3"));
	        musiclist.add(new MusicDTO(mpath + "BattleWin.mp3"));
	        musiclist.add(new MusicDTO(mpath + "Evolution.mp3"));
	        musiclist.add(new MusicDTO(mpath + "FinalBoss.mp3"));
	        musiclist.add(new MusicDTO(mpath + "Login.mp3"));
	        musiclist.add(new MusicDTO(mpath + "MainStart.mp3"));
	        musiclist.add(new MusicDTO(mpath + "PokeRaise.mp3"));
	        musiclist.add(new MusicDTO(mpath + "TheEnd.mp3"));
	    }

	    public MusicDTO P(int i) {
	        if(mp.isPlaying()) {
	            mp.stop();
	        }
	        mp.play(musiclist.get(i).getPath());
	        return musiclist.get(i);
	    }
	    
	    
	    
		public boolean S() {
			boolean result = false;
			if (mp.isPlaying()) {
				mp.stop();
				result = true;
			}
			return result;
		}
}
