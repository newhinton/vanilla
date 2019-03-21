echo "Cleaning up..."
rmdir /Q /s %cd%\out\


echo "Build vanilla apk"
call gradlew assembleDebug

echo "copy result..."
robocopy %cd%\app\build\outputs\apk\debug\ %cd%\out\ app-debug.apk
rename %cd%\out\app-debug.apk vanilla.apk


wsl ./renameCinnamon.sh


echo "Build cinnamon apk"
call gradlew assembleDebug

echo "copy result..."
robocopy %cd%\app\build\outputs\apk\debug\ %cd%\out\ app-debug.apk
rename %cd%\out\app-debug.apk cinnamon.apk

wsl ./renameVanilla.sh