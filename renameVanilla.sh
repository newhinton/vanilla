find app/src/ -type f -print0 | xargs -0 sed -i 's/ch\.newhinton/ch\.blinkenlights/g'
find app/build.gradle -type f -print0 | xargs -0 sed -i 's/ch\.newhinton/ch\.blinkenlights/g'


find app/src/ -type f -print0 | xargs -0 sed -i 's/Audiobooks/Vanilla Music/g'

mv app/src/main/java/ch/newhinton app/src/main/java/ch/blinkenlights