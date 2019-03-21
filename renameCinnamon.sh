find app/src/ -type f -print0 | xargs -0 sed -i 's/ch\.blinkenlights/ch\.newhinton/g'
find app/build.gradle -type f -print0 | xargs -0 sed -i 's/ch\.blinkenlights/ch\.newhinton/g'


find app/src/ -type f -print0 | xargs -0 sed -i 's/Vanilla Music/Audiobooks/g'


mv app/src/main/java/ch/blinkenlights app/src/main/java/ch/newhinton 