<nav class="navbar navbar-expand-lg navbar-dark bg-info">
    <a class="navbar-brand" href="/?">Super internet store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/index">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/computers">Computers</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/phones">Phones</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/tv">Phones</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/white_appliances">Phones</a>
            </li>

            <form class="d-flex" action="/search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>

            <li class="nav-item">
                <button type="button" class="btn btn-primary"
                        data-bs-toggle="modal" data-bs-target="#exampleModal"
                        data-bs-whatever="@fat">Login modal
                </button>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Sign in </a>

                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/register">Register</a>
                    <a class="dropdown-item" href="/login">Sign In</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/logout">Sign out</a>
                </div>
            </li>
        </ul>
    </div>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <div class="tab">
                        <button class="tablinks active" onclick="openTab(event, 'login')">Login</button>
                        <button class="tablinks" onclick="openTab(event, 'register')">Register</button>
                    </div>
                    <div id="login" class="tabcontent">
                        <label for="login_login_modal" class="col-form-label">login:</label>
                        <input type="text" class="form-control" id="login_login_modal">

                        <label for="login_password_modal" class="col-form-label">Pass:</label>
                        <textarea class="form-control" id="login_password_modal"></textarea>
                    </div>
                    <div id="register" class="tabcontent">
                        <label for="register_login_modal" class="col-form-label">Login:</label>
                        <input type="text" class="form-control" id="register_login_modal">

                        <label for="register_password_modal" class="col-form-label">Password:</label>
                        <textarea class="form-control" id="register_password_modal"></textarea>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Send message</button>
                </div>
            </div>
        </div>
    </div>
</nav>