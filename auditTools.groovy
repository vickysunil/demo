def call() {
    node {
        sh '''
            git version
            docker version
            ansible version
        '''
    }
}