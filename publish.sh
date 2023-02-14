./gradlew core:build core:assemble
./gradlew sign -Psigning.secretKeyRingFile="$sign_secretKeyRingFile" -Psigning.password="$sign_password" -Psigning.keyId="$sign_keyId"
./gradlew core:publishLibraryMavenPublicationToOSSRHRepository